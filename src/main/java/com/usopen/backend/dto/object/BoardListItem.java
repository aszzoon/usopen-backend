package com.usopen.backend.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardListItem {
	private int boardNumber;
	private String title;
	private String content;
	private String boardTitleImage;
	private int favoriteCount;
	private int	commentCount;
	private int viewtCount;
	private String writeDatetime;
	private String writeNickname;
	private String writeProfileImage;
}
