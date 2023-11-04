package com.hexaware.onlinegrocery.services;

import java.util.List;

import com.hexaware.onlinegrocery.entity.Substitutions;

public interface ISubstitutionsServices {
	 public int createSubstitution(Substitutions substitution);
	    public int updateSubstitution(Substitutions substitution);
	    public Substitutions getSubstitution(int substitution_id);
	    public List<Substitutions> getAllSubstitutions();
	    public int deleteSubstitution(int substitution_id);
}
