package com.daiso.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BoardVO {
	private int b_num;
	private String b_title;
	private String b_writing;
	private Date b_date;
	private String m_userid;
	private int p_productid;
	
}
