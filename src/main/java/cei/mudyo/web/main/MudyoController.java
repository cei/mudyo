package cei.mudyo.web.main;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cei.codemanager.Trees;
import cei.domains.SystemCode;
import cei.util.TreeHtmlBuilder;

@Controller
@RequestMapping("/mudyo")
public class MudyoController {
	private static final Logger log = LoggerFactory.getLogger(MudyoController.class);
	
	@Autowired
	Trees trees;

	@RequestMapping("/main")
	public String main(Model model) {
		List<SystemCode> list = trees.getTree("SAMPLE", "MENU");
		String menuTag = TreeHtmlBuilder.getString(list);
		
		if(log.isDebugEnabled())
			log.debug("Main menu\n{}", menuTag);

		model.addAttribute("timeToDate", new Date());
		model.addAttribute("list", list);
		model.addAttribute("menu", menuTag);
		return "main";		
	}
}