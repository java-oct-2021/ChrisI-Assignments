package com.javafun.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javafun.dojooverflow.models.Answer;
import com.javafun.dojooverflow.models.Question;
import com.javafun.dojooverflow.models.Tag;
import com.javafun.dojooverflow.services.AnswerService;
import com.javafun.dojooverflow.services.QuestionService;
import com.javafun.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	@Autowired
	QuestionService qServ;
	@Autowired
	TagService tServe;
	@Autowired
	AnswerService aServe;
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", qServ.retrieveAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String createQuestionPage(@ModelAttribute("questionForm") Question questionForm) {
		return "newquestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("questionForm") Question questionForm, BindingResult result, RedirectAttributes ra) {
		if(result.hasErrors()) {
			return "newquestion.jsp";
		} else {
			String tagtext = questionForm.getTagtext();
			List<Tag> tags = new ArrayList<Tag>();
			if(tagtext.length()>0) {
				String[] strArr = tagtext.split(";");
				if(strArr.length > 3) {
					ra.addFlashAttribute("errors", "Maximum of 3 tags allowed");
					return "redirect:/questions/new";
				}
				for (String tagString : strArr) {
					Tag existingTag = tServe.exists(tagString);
					if(existingTag == null) {
						tags.add(tServe.add(new Tag(tagString)));				
					} else {
						Boolean dupe = false;
						for (Tag tag : tags) {
							if(tagString.equals(tag.getSubject())) {
								dupe = true;
								break;
							}
						}
						if(!dupe) {
							tags.add(existingTag);
						}
					}
				}
			}
			questionForm.setTags(tags);
			qServ.add(questionForm);
			return "redirect:/questions";
		}		
	}
	
	@GetMapping("/questions/{questionId}")
	public String getQuestion(
			Model model,
			@PathVariable Long questionId,
			@Valid @ModelAttribute("answerForm") Answer answerForm
			) {
		Question question = qServ.retrieveOne(questionId);
		if(question != null) {
			model.addAttribute("question", question);			
			return "question.jsp";
		} else {
			return "redirect:/questions";
		}
	}
	
	@PostMapping("/questions/{questionId}/answer")
	public String addAnswer(
			@PathVariable Long questionId,
			@Valid @ModelAttribute("answerForm") Answer answerForm,
			BindingResult result,
			RedirectAttributes ra
			) {
		Question question = qServ.retrieveOne(questionId);
		if(question == null) {
			return "redirect:/questions";
		}
		if(result.hasErrors()) {
			return "question.jsp";
		} else {
			answerForm.setQuestion(question);
			Answer answer = aServe.add(answerForm);

			return "redirect:/questions/"+questionId;			
		}
	}

}
