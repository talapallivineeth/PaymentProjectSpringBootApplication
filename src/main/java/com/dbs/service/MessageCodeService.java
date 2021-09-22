package com.dbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.entities.MessageCodeEntity;
import com.dbs.repository.MessageCodeRepository;

@Service
public class MessageCodeService {
	@Autowired
	MessageCodeRepository messageCodeRepository;
	
	public MessageCodeEntity findbyMsgcode(String msgcode)
	{
		java.util.Optional<MessageCodeEntity> optmsgcode = messageCodeRepository.findById(msgcode);
		if(optmsgcode.isPresent())
		{
			return optmsgcode.get();
		}
		else
			return null;
	}
}
