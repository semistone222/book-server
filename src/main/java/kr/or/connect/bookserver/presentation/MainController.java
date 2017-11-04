package kr.or.connect.bookserver.presentation;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	// TODO : error
	@GetMapping("/")
	String index(Model model) {
		model.addAttribute("name", "semistone222");
		return "index";
	}
	
	// TODO : error
	@GetMapping("/n/{shortenedUrl}")
	void redirect(@PathVariable String shortenedUrl) {
		ShortUrl shortUrl = service.findByShortenedUrl(shortenedUrl);
		String originalUrl = shortUrl.getOriginalUrl();
		// TODO : redirect to original url when requested using shortened url
		log.info("redirect to : {}" + shortUrl);
	}

}
