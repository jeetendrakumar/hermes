package com.dotloop.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dotloop.model.AgentPhone;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("agentPhoneItemWriter")
public class AgentPhoneItemWriter implements ItemWriter<AgentPhone> {

	private static final Log log = LogFactory
			.getLog(AgentPhoneItemWriter.class);

	private static final String INSERT_AGENT_PHONE = "INSERT INTO AGENT_PHONE (AGENT_GUID, PHONE_TYPE, PHONE_NO, EXT_OR_PIN) values (?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends AgentPhone> agentPhones) throws Exception {
		log.info(agentPhones);
		for (AgentPhone agentPhone : agentPhones) {

			jdbcTemplate.update(INSERT_AGENT_PHONE, agentPhone.getAgentGuid(),
					agentPhone.getPhoneType(), agentPhone.getPhoneNo(),
					agentPhone.getExtOrPin());
		}
	}
}
