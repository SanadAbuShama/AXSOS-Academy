
from django.db import models


class Description(models.Model):
    text = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"<Description object: {self.text}>"


class CourseManager(models.Manager):
    def course_validator(self, postData):
        errors = {}

        if len(postData['name']) < 5:
            errors['name'] = 'Course name should be at least 5 characters'
        if len(postData['desc']) < 15:
            errors['desc'] = 'Course description should be at least 15 characters'
        return errors


class Course(models.Model):
    name = models.CharField(max_length=255)
    description = models.OneToOneField(
        Description, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = CourseManager()

    def __str__(self):
        return f"<Course object: {self.name} >"


class Comment(models.Model):
    text = models.TextField()
    course = models.ForeignKey(
        Course, related_name="comments", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f"<Course object: {self.text} >"
