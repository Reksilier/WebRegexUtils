package reksilier.regexputil.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import reksilier.regexputil.service.ReplacerService;
import reksilier.regexputil.service.replace.NextNumberReplacementResolver;
import reksilier.regexputil.service.replace.RandomFromListReplacementResolver;
import reksilier.regexputil.service.replace.ReplacementResolver;
import reksilier.regexputil.web.formbeans.TextFormBean;
import reksilier.regexputil.web.formbeans.TextReplacementsFormBean;

import java.util.Map;

@Controller
public class TextReplacerController {
	
	private final Logger logger = LoggerFactory.getLogger(TextReplacerController.class);
	
	@Qualifier("regexpReplacerService")
	private final ReplacerService replacerWithSequence;
	
	@Autowired
	public TextReplacerController(ReplacerService replacerWithSequence) {
		this.replacerWithSequence = replacerWithSequence;
	}
	
	@RequestMapping(value = {"/", "/numbersReplace"}, method = RequestMethod.GET)
	public String numbersReplace(Map<String, Object> model) {
		logger.debug("numbersReplace() is executed!");
		if(!model.containsKey("textFormBean")) {
			model.put("textFormBean", new TextFormBean());
		}
		return "numbersReplace";
	}
	
	@RequestMapping(value = "/numbersReplace", method = RequestMethod.POST)
	public String numbersReplaceFormHandle(@ModelAttribute("textFormBean") TextFormBean textFormBean,
	                               BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.asMap().put("textFormBean", new TextFormBean());
			return "numbersReplace";
		} else {
			ReplacementResolver replacementResolver = new NextNumberReplacementResolver(textFormBean.getStartingNumber(), textFormBean.isDescendingOrder());
			String resultText = replacerWithSequence.replaceSubStringsInText(textFormBean.getText(), textFormBean.getReplacement(), replacementResolver);
			redirectAttributes.addFlashAttribute("resultText", resultText);
			redirectAttributes.addFlashAttribute("textFormBean", textFormBean);
			logger.debug("Textformbean: {}", textFormBean);
			// POST/REDIRECT/GET
			return "redirect:/numbersReplace";
		}
	}
	
	@RequestMapping(value = {"/valuesInRandomReplace"}, method = RequestMethod.GET)
	public String valuesInRandomReplace(Map<String, Object> model) {
		logger.debug("valuesInRandomReplace() is executed!");
		if(!model.containsKey("textFormBean")) {
			model.put("textFormBean", new TextReplacementsFormBean());
		}
		return "valuesInRandomReplace";
	}
	
	@RequestMapping(value = "/valuesInRandomReplace", method = RequestMethod.POST)
	public String valuesInRandomReplaceFormHandle(@ModelAttribute TextReplacementsFormBean textFormBean,
	                               BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.asMap().put("textFormBean", new TextReplacementsFormBean());
			return "valuesInRandomReplace";
		} else {
			ReplacementResolver replacementResolver = new RandomFromListReplacementResolver(textFormBean.getReplacings());
			String resultText = replacerWithSequence.replaceSubStringsInText(textFormBean.getText(), textFormBean.getReplacement(), replacementResolver);
			redirectAttributes.addFlashAttribute("resultText", resultText);
			redirectAttributes.addFlashAttribute("textFormBean", textFormBean);
			logger.info("textFormBean="+textFormBean);
			// POST/REDIRECT/GET
			return "redirect:/valuesInRandomReplace";
		}
	}
}