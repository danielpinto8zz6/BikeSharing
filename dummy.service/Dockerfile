FROM python:3.8-slim
ADD . ./opt/
WORKDIR /opt/
EXPOSE 5000
RUN pip install --upgrade pip
RUN pip install -r requirements.txt
CMD ["python","main.py"]