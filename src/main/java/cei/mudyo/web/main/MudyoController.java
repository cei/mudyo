package cei.mudyo.web.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/@mudyo")
public class MudyoController {
	private static final Logger log = LoggerFactory.getLogger(MudyoController.class);
	
	@RequestMapping("")
	public String main(Model model) {
		return "main";		
	}
}