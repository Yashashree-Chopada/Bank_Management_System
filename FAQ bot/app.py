import finalchatbot
from flask import Flask, render_template, request

app = Flask(__name__)
app.static_folder = 'static'

@app.route("/")
def home():
    return render_template("index.html")

@app.route("/get")
def get_bot_response():
    userText = request.args.get('msg')
    vari=default(userText)
    if(vari == 1):
        ans=finalchatbot.chat(userText)
    else:
        ans=vari
    return str(ans)


def default(argument):
    switcher = {
        "What is your name": "My Name is Bank bot",
        "Are you a bot": "Yeah! I am a robot",
        "hi": "hi!How you doing",
        "hii": "hii!How you doing",
        "Who made you":"Group G1",

    }

    return switcher.get(argument,1)
if __name__ == "__main__":
    app.run()