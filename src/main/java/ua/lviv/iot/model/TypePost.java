package ua.lviv.iot.model;

public class TypePost {
  private int typePostId;
  private String type;

	public int getTypePostId() {
		return typePostId;
	}
	
	public void setTypePostId(int typePostId) {
		this.typePostId = typePostId;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TypePost [id_type_post=" + typePostId + ", type=" + type + "]" + "\n";
	}
}
