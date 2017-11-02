package kr.or.connect.bookserver.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookserver.domain.ShortUrl;
import kr.or.connect.bookserver.service.ShortUrlService;

@RestController
@RequestMapping("/api/surls")
public class ShortUrlController {
	private final Logger log = LoggerFactory.getLogger(ShortUrlController.class);
	
	private final ShortUrlService service;
	
	@Autowired
	public ShortUrlController(ShortUrlService service) {
		this.service = service;
	}
	
	@GetMapping
	Iterable<ShortUrl> readList() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	ShortUrl read(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	ShortUrl create(@RequestBody ShortUrl shortUrl) {
		ShortUrl newShortUrl = service.create(shortUrl);
		log.info("shortUrl created : {}" , newShortUrl);
		return newShortUrl;
	}
}
