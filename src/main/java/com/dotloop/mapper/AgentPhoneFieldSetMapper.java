package com.dotloop.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.dotloop.model.AgentPhone;

public class AgentPhoneFieldSetMapper implements FieldSetMapper<AgentPhone> {

	public AgentPhone mapFieldSet(FieldSet fieldSet) throws BindException {
		AgentPhone agentPhone = new AgentPhone();
		agentPhone.setAgentGuid(fieldSet.readString(0));
		agentPhone.setPhoneType(fieldSet.readString(1));
		agentPhone.setPhoneNo(fieldSet.readString(2));
		agentPhone.setExtOrPin(fieldSet.readString(3));
		return agentPhone;
	}

}
