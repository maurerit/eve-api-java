package com.tlabs.eve.api.corporation;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2012 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.tlabs.eve.api.AccountBalance;
import com.tlabs.eve.api.AccountBalanceResponse;
import com.tlabs.eve.api.WalletJournalResponse;
import com.tlabs.eve.api.WalletTransactionsResponse;

public final class CorporationWalletTest extends CorporationApiTest {


    @Test(timeout=10000)
    public void testCorporationBalance() throws Exception {     
        AccountBalanceResponse r = 
            apiCall(            
                new CorporationAccountBalanceRequest(corporationKey.id)); 
        
        List<AccountBalance> account = r.getAccountBalance();
        assertTrue("Account size=0", account.size() > 0);
    }   

    @Test(timeout=10000)
    public void testFullCorporationWallet() throws Exception {
        WalletJournalResponse journal = 
            apiCall(new CorporationWalletJournalRequest(corporationKey.id, 1000));
        
        WalletTransactionsResponse transactions = 
            apiCall(new CorporationWalletTransactionsRequest(corporationKey.id, 1000));     
    }   
    
}
