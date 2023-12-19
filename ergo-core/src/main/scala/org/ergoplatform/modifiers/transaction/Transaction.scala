package org.ergoplatform.modifiers.transaction

import org.ergoplatform.EphemerealNodeViewModifier
import org.ergoplatform.modifiers.{NetworkObjectTypeId, TransactionTypeId}
import scorex.crypto.hash.Blake2b256
import scorex.util.{ModifierId, bytesToId}


/**
  * A transaction is an atomic state modifier
  */
trait Transaction extends EphemerealNodeViewModifier {
  override val modifierTypeId: NetworkObjectTypeId.Value = TransactionTypeId.value

  val messageToSign: Array[Byte]

  override lazy val id: ModifierId = bytesToId(Blake2b256(messageToSign))
}