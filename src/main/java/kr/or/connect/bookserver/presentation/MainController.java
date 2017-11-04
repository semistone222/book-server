package kr.or.connect.bookserver.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.bookserver.domain.ShortUrl;
import kr.or.connect.bookserver.service.ShortUrlService;

@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(MainController.class);
	
	private final ShortUrlService service;
	
	@Autowired
	public MainController(ShortUrlService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/{shortenedUrl}")
	String redirect(@PathVariable("shortenedUrl") String shortenedUrl) {
		ShortUrl shortUrl = service.findByShortenedUrl(shortenedUrl);
		if(shortUrl == null) {
			log.info("there is no available short url.");
			// TODO : redirect to 404
			return "index";
		} else {
			String originalUrl = shortUrl.getOriginalUrl();
			log.info("redirect to : {}" + shortUrl);
			return "redirect:" + originalUrl;
		}
	}
}
