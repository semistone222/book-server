package kr.or.connect.bookserver.service;

import org.springframework.stereotype.Service;

import kr.or.connect.bookserver.domain.ShortUrl;
import kr.or.connect.bookserver.persistence.ShortUrlRepository;
import kr.or.connect.bookserver.util.Base62;

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
	
	public ShortUrl create(String originalUrl) {
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setOriginalUrl(originalUrl);
		shortUrl = shortUrlRepository.save(shortUrl);
		shortUrl.setShortenedUrl(Base62.base62(shortUrl.getId()));
		shortUrl = shortUrlRepository.save(shortUrl);
		return shortUrl;
	}
}
