#import chatbot
import pandas as pd
import numpy as np
import pickle
import operator
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split as tts
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.preprocessing import LabelEncoder as LE
from sklearn.metrics.pairwise import cosine_similarity
import random
import nltk
from nltk.stem.lancaster import LancasterStemmer
import app
#import chatbot1
import nltk
#from chatterbot import ChatBot
#from chatterbot.trainers import ListTrainer
#from chatterbot.trainers import ChatterBotCorpusTrainer

from nltk import LancasterStemmer
ans1=""
dict = {0: 'accounts', 1: 'cards', 2: 'fundstransfer', 3: 'insurance', 4: 'investments', 5: 'loans', 6: 'security',
        7: 'default'}
stemmer = LancasterStemmer()


def cleanup(sentence):
    word_tok = nltk.word_tokenize(sentence)
    stemmed_words = [stemmer.stem(w) for w in word_tok]

    return ' '.join(stemmed_words)


le = LE()

tfv = TfidfVectorizer(min_df=1, stop_words='english')

data = pd.read_csv('BankFAQs.csv')
questions = data['Question'].values

X = []
for question in questions:
    X.append(cleanup(question))

tfv.fit(X)
le.fit(data['Class'])

X = tfv.transform(X)
y = le.transform(data['Class'])

trainx, testx, trainy, testy = tts(X, y, test_size=.25, random_state=42)

model = SVC(kernel='linear')
model.fit(trainx, trainy)
print("SVC:", model.score(testx, testy))


def get_max5(arr):
    ixarr = []
    for ix, el in enumerate(arr):
        ixarr.append((el, ix))
    ixarr.sort()

    ixs = []
    for i in ixarr[-5:]:
        ixs.append(i[1])

    return ixs[::-1]


def chat(user_text):

    usr=user_text
    print(usr)

    t_usr = tfv.transform([cleanup(usr.strip().lower())])
    # print(t_usr)
    class2_ = model.predict(t_usr)[0]
    # print(class2_)
    class_ = dict.get(class2_)
    # class_ = le.inverse_transform(class2_)
    questionset = data[data['Class'] == class_]


    cos_sims = []
    for question in questionset['Question']:
         sims = cosine_similarity(tfv.transform([question]), t_usr)
         cos_sims.append(sims)
    #
    #print(max(cos_sims))
    #res = str(cos_sims)[1:-1]

    if(max(cos_sims)>0.5):
        ind = cos_sims.index(max(cos_sims))
        ans1=data['Answer'][questionset.index[ind]]
    else:
        ans1="Sorry, I didnt understand Can you rephrase the question."

    return ans1


