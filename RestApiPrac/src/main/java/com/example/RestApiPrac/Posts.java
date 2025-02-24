package com.example.RestApiPrac;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Posts.PostsBuilder.class)
public class Posts{
	private int id;
	private String title;
	private String body;
	private int userId;

	public Posts(PostsBuilder posts) {
		this.id = posts.id;
		this.title = posts.title;
		this.body = posts.body;
		this.userId = posts.userId;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public int getUserId(){
		return userId;
	}

	@Override
	public String toString(){
		return
				"Posts{" +
						"id = '" + id + '\'' +
						",title = '" + title + '\'' +
						",body = '" + body + '\'' +
						",userId = '" + userId + '\'' +
						"}";
	}
	@JsonPOJOBuilder(withPrefix = "set")
	static class PostsBuilder{
		private int id;
		private String title;
		private String body;
		private int userId;

		public PostsBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public PostsBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public PostsBuilder setBody(String body) {
			this.body = body;
			return this;
		}

		public PostsBuilder setUserId(int userId) {
			this.userId = userId;
			return this;
		}

		public Posts build(){
			return new Posts(this);
		}
	}
}
