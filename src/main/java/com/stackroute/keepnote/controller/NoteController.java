package com.stackroute.keepnote.controller;


import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 * 
	 * 1. display the list of existing notes from the collection. Each note 
	 *    should contain Note Id, title, content, status and created date.
	 * 2. Add a new note which should contain the note id, title, content and status.
	 * 3. Delete an existing note.
	 * 4. Update an existing note.
	 */


	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/beans.xml");
	private Note note = (Note)applicationContext.getBean("note");
    private NoteRepository noteRepository = (NoteRepository)applicationContext.getBean("noteRepository");

	@RequestMapping("/")
	public String getAllNotes(Model model) {
		Map<String, Object> responseobject = new HashMap<>();
		responseobject.put("notes", noteRepository.getAllNotes());
		model.addAttribute("status", "success");
		model.mergeAttributes(responseobject);
		return "index";
	}

	@RequestMapping("/saveNote")
	public String addNote(@ModelAttribute Note noteDetails, Model model) {
		noteRepository.addNote(noteDetails);
		return getAllNotes(model);
	}

	@RequestMapping("/deleteNote")
	public String deleteNote(@RequestParam(name = "noteId") int noteId) {
		noteRepository.deleteNote(noteId);
		return "redirect:/";
	}
	/* 
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the Note object from the context.
	 * Retrieve the NoteRepository object from the context.
	 */
	
	
	/*Define a handler method to read the existing notes by calling the getAllNotes() method 
	 * of the NoteRepository class and add it to the ModelMap which is an implementation of Map 
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */
	
	
	/*Define a handler method which will read the Note data from request parameters and
	 * save the note by calling the addNote() method of NoteRepository class. Please note 
	 * that the createdAt field should always be auto populated with system time and should not be accepted 
	 * from the user. Also, after saving the note, it should show the same along with existing 
	 * notes. Hence, reading notes has to be done here again and the retrieved notes object 
	 * should be sent back to the view using ModelMap.
	 * This handler method should map to the URL "/saveNote". 
	*/
	
	
	/* Define a handler method to delete an existing note by calling the deleteNote() method 
	 * of the NoteRepository class
	 * This handler method should map to the URL "/deleteNote" 
	*/
	
}