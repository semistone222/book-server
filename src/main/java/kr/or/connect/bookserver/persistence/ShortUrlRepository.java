package kr.or.connect.bookserver.persistence;

import org.springframework.data.repository.CrudRepository;

import kr.or.connect.bookserver.domain.ShortUrl;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {
	
	ShortUrl findByShortenedUrl(String shortenedUrl);	
}
