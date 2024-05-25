package com.usopenblog.usopen_blog_backend_20240515.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommetListItem {
	private String nickname;
	private String profileImage;
	private String writeDatetime;
	private String content;
}
