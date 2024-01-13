package com.listening_ielts.service;

import com.listening_ielts.entity.Part;

public interface IPartService {
	boolean insertPart(Part part);
	Part findMaPart(int maDeThi, int partNum);
}
