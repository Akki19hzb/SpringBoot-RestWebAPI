package io.hzb.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics= new ArrayList<Topic>( Arrays.asList(
			new Topic("Spring","Spring Boot","Spring Boot Tutorial"),
			new Topic("Java","Java 8","Java 8 Features"),
			new Topic("JavaScript","JavaScript ES6","JavaScript is Sexy")));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void add(Topic topic) {
		topics.add(topic);
	}

	public void update(Topic topic, String id) {
		for(int i=0; i<topics.size();i++) {
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void delete(String id) {
		topics.removeIf(t->t.getId().equals(id));
		
	}

	
}

