package com.sanad.dojooverflow.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sanad.dojooverflow.models.Answer;
import com.sanad.dojooverflow.models.Question;
import com.sanad.dojooverflow.models.Tag;
import com.sanad.dojooverflow.repositories.AnswerRepository;
import com.sanad.dojooverflow.repositories.QuestionRepository;
import com.sanad.dojooverflow.repositories.TagRepository;

@Service
public class MainService {

	@Autowired
	private QuestionRepository quesRepo;

	@Autowired
	private AnswerRepository ansRepo;

	@Autowired
	private TagRepository tagRepo;

	public List<Question> allQuestions() {
		return quesRepo.findAllByOrderByCreatedAtDesc();
	}

	public void createQuestion(String tags, Question newQuestion, BindingResult result) {
		String[] splitTags = tags.split(",");

		if (tags.length() > 0) {

			if (splitTags.length == 1 && !Pattern.matches("([a-z]+)(,[a-z]+){0,}", tags)) {
				result.rejectValue("question", "Length",
						"Only maximum of three, comma seperated, and lowercase tags are allowd!");
			} else if (splitTags.length == 2 && !Pattern.matches("([a-z]+)(,[a-z]+){1,}", tags)) {
				result.rejectValue("question", "Length",
						"Only maximum of three, comma seperated, and lowercase tags are allowd!");
			} else if (splitTags.length == 3 && !Pattern.matches("([a-z]+)(,[a-z]+){2,}", tags)) {
				result.rejectValue("question", "Length",
						"Only maximum of three, comma seperated, and lowercase tags are allowd!");
			} else if (splitTags.length > 3) {
				result.rejectValue("question", "Length",
						"Only maximum of three, comma seperated, and lowercase tags are allowd!");
			}

		}

		if (!result.hasErrors()) {
			if (tags.length() > 0) {
				for (String splitTag : splitTags) {
					Optional<Tag> optionalTag = tagRepo.findBySubject(splitTag);
					if (optionalTag.isPresent()) {
						newQuestion.getTags().add(optionalTag.get());
					} else {
						Tag newTag = new Tag();
						newTag.setSubject(splitTag);
						Tag savedTag = tagRepo.save(newTag);
						newQuestion.getTags().add(savedTag);
					}

				}
			}
			quesRepo.save(newQuestion);

		}

	}

	public Question findQuestionById(Long id) {
		Optional<Question> q = quesRepo.findById(id);
		if (q.isPresent()) {
			return q.get();
		} else {
			return null;
		}

	}

	public void addAnswer(Long questionId, Answer newAnswer) {

		Question ques = this.findQuestionById(questionId);
		newAnswer.setQuestion(ques);
		ansRepo.save(newAnswer);
	}

}
