package by.koval.bankcards.service;

import by.koval.bankcards.entity.BlockRequest;

import java.util.List;

public interface BlockRequestService {
    List<BlockRequest> getBlockRequests();
    BlockRequest getBlockRequest(int id);
}
