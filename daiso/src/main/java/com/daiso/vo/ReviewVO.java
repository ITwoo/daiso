package com.daiso.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Component

public class ReviewVO {
	private int r_num;
	private String r_comment;
	private Date r_date;
	private int b_num;
	private String m_userid;
}
