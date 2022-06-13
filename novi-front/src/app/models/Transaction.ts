export interface Transaction {
    payerId: Number,
    recipientId: Number,
    totalAmount: Number,
  }

  export interface TransactionView {
    payer: String,
	  recipient: String,
	  date: Date,
	  amount: Number
  }