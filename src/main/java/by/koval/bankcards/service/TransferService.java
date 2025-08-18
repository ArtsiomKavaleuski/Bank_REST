package by.koval.bankcards.service;

import by.koval.bankcards.entity.Transfer;

import java.util.List;

public interface TransferService {
    List<Transfer> getTransfers();
    Transfer getTransfer(long id);
    Transfer createTransfer(Transfer transfer);
}
