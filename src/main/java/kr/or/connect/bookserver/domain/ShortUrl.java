package kr.or.connect.bookserver.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SURL")
public class ShortUrl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String originalUrl;
	// TODO : shortenedUrl is not too good naming to save like 'EXSvs' rather than 'localhost:8080/ExSvs'
	private String shortenedUrl;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOriginalUrl() {
		return originalUrl;
	}


	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}


	public String getShortenedUrl() {
		return shortenedUrl;
	}


	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "ShortUrl [id=" + id + ", originalUrl=" + originalUrl + ", shortenedUrl=" + shortenedUrl + ", createdAt="
				+ createdAt + "]";
	}
}
