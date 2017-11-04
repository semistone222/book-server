package kr.or.connect.bookserver.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.bookserver.domain.ShortUrl;
import kr.or.connect.bookserver.service.ShortUrlService;

@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(MainController.class);
	private final ShortUrlService service;
	@Value("${server.address}")
    private String serverAddress;
    @Value("${server.port}")
    private String serverPort;
	
	@Autowired
	public MainController(ShortUrlService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	String index(@RequestParam(value="name", required=false, defaultValue="Link") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/404")
	String error(@RequestParam(value="link", required=false) String link, Model model) {
		model.addAttribute("link", link);
		return "404";
	}
	
	@GetMapping("/{shortened}")
	String redirect(@PathVariable("shortened") String shortened, RedirectAttributes redirectAttributes) {
		log.info("shortened : " + shortened);
		ShortUrl shortUrl = service.findByShortenedUrl(shortened);
		if(shortUrl == null) {
			log.info("there is no available short url.");
			redirectAttributes.addAttribute("link", serverAddress + ":" + serverPort + "/" + shortened);
			return "redirect:/404";
		} else {
			String originalUrl = shortUrl.getOriginalUrl();
			log.info("redirect to : {}" + shortUrl);
			// TODO : if originalUrl is not good, then redirect to this again. how to fix?
			return "redirect:" + originalUrl;
		}
	}
}
