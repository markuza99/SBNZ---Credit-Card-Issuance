export interface CreditCard {
    id: Number,
    cardNumber: String,
    cardBrand: String,
    cardOwner: String,
    isBlocked: Boolean,
    limit: Number,
    deposit: Number,
    expirationDate: String
  }