package LLD.Messaging.services;

import java.util.List;

import LLD.Messaging.model.Conversation;
import LLD.Messaging.model.Message;

public class MessagingService {

        private final ConversationService conversationService;

        private final MessageService messageService;

        private final NotificationService notificationService;

        public MessagingService(ConversationService conversationService,MessageService messageService,NotificationService notificationService) {
                this.conversationService = conversationService;
                this.messageService =messageService;
                this.notificationService = notificationService;
        }

        public Message sendMessage(String conversationId,String senderId,String content) {

                Conversation conversation = conversationService.findConversationById(conversationId);

                messageService.validateSender(conversation,senderId);

                long sequenceNumber =conversation.getNextSequenceNumber();

                Message message = messageService.createMessage(conversationId,senderId,content,sequenceNumber);

                conversationService.addMessageToConversation(conversationId,message);

                notificationService.notifyParticipants(conversation,senderId,content);

                return message;
        }

       

 

}