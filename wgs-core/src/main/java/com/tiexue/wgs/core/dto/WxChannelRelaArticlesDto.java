package com.tiexue.wgs.core.dto;

import java.util.List;

public class WxChannelRelaArticlesDto {

	
	/**
	 * 频道信息
	 */
	private WgsChannelDto wgsChannelDto;
	
	/**
	 * 频道对应的文章
	 */
	private List<WgsArticleDto> wgsArticleDtos;

	public WgsChannelDto getWgsChannelDto() {
		return wgsChannelDto;
	}

	public void setWgsChannelDto(WgsChannelDto wgsChannelDto) {
		this.wgsChannelDto = wgsChannelDto;
	}

	public List<WgsArticleDto> getWgsArticleDtos() {
		return wgsArticleDtos;
	}

	public void setWgsArticleDtos(List<WgsArticleDto> wgsArticleDtos) {
		this.wgsArticleDtos = wgsArticleDtos;
	}
	
	

}
