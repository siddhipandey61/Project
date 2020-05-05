package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.fms.model.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {
	@PersistenceContext
	EntityManager entityManager;

	// This module will add the schedule in the Schedule table.
	@Override
	public void addSchedule(Schedule schedule) {
		entityManager.persist(schedule);
	}
	
	// This module will retrieve the schedule in the Schedule table.
	@Override
	public Schedule retrieveSchedule(int scheduleid) {
		return entityManager.find(Schedule.class, scheduleid);
	}
	
	// This module will retrieve all schedules in the Schedule table.
	@Override
	public List<Schedule> retrieveAllSchedule() {
			String query = "select schedule from Schedule schedule";
			TypedQuery<Schedule> q = entityManager.createQuery(query, Schedule.class);
			return q.getResultList();
		}

	// This module will update the schedule in the Schedule table.
	@Override
	public void updateSchedule(Schedule schedule) {
		entityManager.getTransaction().begin();
		entityManager.merge(schedule);
		entityManager.getTransaction().commit();
	}

	// This module will delete the schedule in the Schedule table.
	@Override
	public boolean deleteSchedule(int scheduleid) {
		Schedule schedule = entityManager.find(Schedule.class, scheduleid);
		if(schedule !=null)
		{
			entityManager.remove(schedule);
			return true;
		}
		else 
		return false;
		
	}


	}


