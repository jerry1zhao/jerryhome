// Copyright (c) 2018 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2018-XX-XX, Jerry, creation
// ============================================================================

package pers.jerry.quick.post.domain;

/**
 * @author Jerry
 *
 */
public class PostCarousel {
	private int id;
    private int postId;
	private String description;
    private String carouselImage;
    /**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    /**
	 * @return the carouselImage
	 */
	public String getCarouselImage() {
		return carouselImage;
	}
	/**
	 * @param carouselImage the carouselImage to set
	 */
	public void setCarouselImage(String carouselImage) {
		this.carouselImage = carouselImage;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
}
