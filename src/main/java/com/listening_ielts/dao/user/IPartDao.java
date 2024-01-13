package com.listening_ielts.dao.user;

import com.listening_ielts.entity.Part;

public interface IPartDao {
	boolean insertPart(Part part);
	Part findMaPart(int maDeThi, int partNum);
}
