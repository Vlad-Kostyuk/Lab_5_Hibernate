package ua.lviv.iot.model;

public class MediaType {
  private int mediaTypeId;
  private String mediaType;

	public int getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
	public String getMediaType() {
		return mediaType;
	}
	
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public String toString() {
		return "MediaType [id_media_type=" + mediaTypeId + ", media_type=" + mediaType + "]" + "\n";
	}
}
