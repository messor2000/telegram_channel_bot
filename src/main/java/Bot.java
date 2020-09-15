import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private static final String botUserName = "@YourPhotoForStories_bot:";
    private static final String token = "1322849383:AAGssEvXlmpJi0cRNV_TZ7KyZf15-XHI8jo";

    public void onUpdateReceived(Update update) {
        update.getUpdateId();

        String chat_id = String.valueOf(update.getMessage().getChatId());
        SendMessage sendMessage = new SendMessage().setChatId(chat_id);

        String msg = update.getMessage().getText();
        if(msg.equals("/start")){
            sendMessage.setText("Что бы отправить нам свои фото/видео , нажмите на скрепочку в левом нижнем углу экрана,выберите нужные фото/видео,и нажмите «отправить»");

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
