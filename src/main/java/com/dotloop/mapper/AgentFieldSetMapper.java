package com.dotloop.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.dotloop.model.Agent;

public class AgentFieldSetMapper implements FieldSetMapper<Agent> {

	public Agent mapFieldSet(FieldSet fieldSet) throws BindException {
		Agent agent = new Agent();
		agent.setAgentGuid(fieldSet.readString(0));
		agent.setOfficeGuid(fieldSet.readString(1));
		agent.setBrand(fieldSet.readString(2));
		agent.setAgentKey(fieldSet.readString(3));
		agent.setSaId(fieldSet.readString(4));
		return agent;
	}

}
