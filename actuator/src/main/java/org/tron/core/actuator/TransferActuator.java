package org.tron.core.actuator;

import static org.tron.core.config.Parameter.ChainConstant.TRANSFER_FEE;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Arrays;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.tron.common.utils.Commons;
import org.tron.common.utils.DecodeUtil;
import org.tron.common.utils.StringUtil;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.ContractCapsule;
import org.tron.core.capsule.TransactionResultCapsule;
import org.tron.core.exception.BalanceInsufficientException;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.AccountStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol.AccountType;
import org.tron.protos.Protocol.Transaction.Contract.ContractType;
import org.tron.protos.Protocol.Transaction.Result.code;
import org.tron.protos.contract.BalanceContract.TransferContract;

import org.tron.core.capsule.TransactionCapsule;
import org.tron.core.db.Manager;
import org.tron.protos.Contract;
import org.tron.protos.Protocol.Transaction.Result.code;
import org.tron.common.runtime.vm.program.InternalTransaction;

public class TransferActuator extends AbstractActuator {

    public TransferActuator(Contract.TransferContract contract, Manager dbManager) {
        super(contract, dbManager);
    }

    @Override
    public boolean validate() throws ContractValidateException {
        // Skipping balance validation entirely
        System.out.println("Custom validation: Skipping balance verification.");
        return true; // Always pass validation
    }

    @Override
    public void execute(TransactionCapsule transactionCapsule) throws ContractExeException {
        Contract.TransferContract transferContract;
        try {
            transferContract = this.contract.unpack(Contract.TransferContract.class);
        } catch (Exception e) {
            throw new ContractExeException(e.getMessage());
        }

        long transferAmount = transferContract.getAmount();
        System.out.println("Executing transfer with amount: " + transferAmount);

        // Example: Perform minimal processing (you can add custom logic here)
        transactionCapsule.setResult(code.SUCESS);
    }
}
