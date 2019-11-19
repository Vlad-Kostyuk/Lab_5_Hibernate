package ua.lviv.iot.model;

public class FotoAndVideo {
  private int idFotoOrVideo;
  private int postId;
  private int mediaTypeId;
  private String format;
  private String url;

	public int getIdFotoOrVideo() {
		return idFotoOrVideo;
	}
	
	public void setIdFotoOrVideo(int idFotoOrVideo) {
		this.idFotoOrVideo = idFotoOrVideo;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public int getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FotoAndVideo [id_foto_or_video=" + idFotoOrVideo + ", id_post=" + postId + ", id_media_type="
				+ mediaTypeId + ", format=" + format + ", url=" + url + "]" + "\n";
	}
}
