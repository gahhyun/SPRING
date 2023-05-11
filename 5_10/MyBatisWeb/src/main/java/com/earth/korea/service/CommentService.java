package com.earth.korea.service;

import java.util.List;

import com.earth.korea.domain.CommentDTO;

public interface CommentService {
	
	List<CommentDTO> getList(Integer bno) throws Exception;
	
	int remove(Integer cno, Integer bno, String commenter) throws Exception;
	
	int write(CommentDTO commentDTO) throws Exception;
	
	int modify(CommentDTO commentDTO) throws Exception;
	

}
