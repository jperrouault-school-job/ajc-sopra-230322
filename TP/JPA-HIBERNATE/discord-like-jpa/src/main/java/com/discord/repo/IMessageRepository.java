package com.discord.repo;

import java.util.List;

import com.discord.model.Message;

public interface IMessageRepository extends IRepository<Message, Integer> {
	public List<Message> findAllTop10BySalonId(int salonId);
}
