from django.db import models
from login_registration_app.models import User

class Message(models.Model):
    message = models.TextField()
    posted_by = models.ForeignKey(
        User, related_name="posted_messages", on_delete=models.CASCADE)
    posted_to = models.ForeignKey(
        User, related_name="wall_messages", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"<Message object: {self.message}>"

class Reply(models.Model):
    reply = models.TextField()
    posted_by = models.ForeignKey(
        User, related_name="replies", on_delete=models.CASCADE)
    message = models.ForeignKey(
        Message, related_name="replies", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"<Comment object: {self.reply}>"