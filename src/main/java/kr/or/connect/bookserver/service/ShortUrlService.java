package kr.or.connect.bookserver.service;

import org.springframework.stereotype.Service;

import kr.or.connect.bookserver.domain.ShortUrl;
import kr.or.connect.bookserver.persistence.ShortUrlRepository;

@Service
public class ShortUrlService {
	private ShortUrlRepository shortUrlRepository;

	public ShortUrlService(ShortUrlRepository shortUrlRepository) {
		this.shortUrlRepository = shortUrlRepository;
	}
	
	public Iterable<ShortUrl> findAll() {
		return shortUrlRepository.findAll();
	}
	
	public ShortUrl findById(Long id) {
		return shortUrlRepository.findOne(id);
	}
	
	public ShortUrl findByShortenedUrl(String shortenedUrl) {
		return shortUrlRepository.findByShortenedUrl(shortenedUrl);
	}
	
	public ShortUrl create(ShortUrl shortUrl) {
		return shortUrlRepository.save(shortUrl);
	}
}
