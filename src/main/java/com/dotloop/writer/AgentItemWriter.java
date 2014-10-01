package com.dotloop.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dotloop.model.Agent;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("agentItemWriter")
public class AgentItemWriter implements ItemWriter<Agent> {

	private static final Log log = LogFactory.getLog(AgentItemWriter.class);

	private static final String INSERT_AGENT = "insert into AGENT (AGENT_GUID, OFFICE_GUID, BRAND, AGENT_KEY, SA_ID) values (?,?,?,?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Agent> agents) throws Exception {
		log.info(agents);
		for (Agent agent : agents) {

			jdbcTemplate.update(INSERT_AGENT, agent.getAgentGuid(),
					agent.getOfficeGuid(), agent.getBrand(),
					agent.getAgentKey(), agent.getSaId());
		}
	}

}
