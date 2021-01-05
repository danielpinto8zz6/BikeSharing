from kafka import KafkaProducer
from flask import (
    Flask,
    render_template
)

# Create the application instance
app = Flask(__name__, template_folder="templates")

producer = KafkaProducer(bootstrap_servers='localhost:1234')

@app.route('/bike-inserted')
def bike_inserted():
    print("bike inserted...")
    return "ok"

@app.route('/unlock-bike')
def unlock_bike():
    print("unlocking bike...")
    producer.send('unlock', b'unlock bike')
    return "ok"


# If we're running in stand alone mode, run the application
if __name__ == '__main__':
    app.run(debug=True)
