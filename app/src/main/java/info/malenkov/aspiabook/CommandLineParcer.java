package info.malenkov.aspiabook;

/**
 *
 * @author Максим В. Маленьков
 * 
 * V.01.01
 * 
 */
public class CommandLineParcer
{
    final String separator = "=";   // Разделитель. Отделяет название ключа от его значения
    String args[];                  // Массив содержащий список полученных параметров коммандной строки
    String keys[];                  // (Опционально) Список ожидаемых ключей. Это позволяет легко найти не правильных ключи. 
    boolean caseSensitive = false;  // Являются ли ключи командной строки зависимыми от регистра
    int keysCount = 0;
    
    // Создаем объект CommandLineParcer и передаем ему список полученных с коммандной строки аргументов
    public CommandLineParcer(String[] args)
    {
        this.args = args;
        fixParameters();
    }
    
    // Создаем объект CommandLineParcer и передаем ему список полученных с коммандной строки аргументов
    // Дополнительно передаем список обязательных ключей
    public CommandLineParcer(String[] args, String[] keys)
    {
        this.args = args;
        this.keys = keys;
        fixParameters();
    }

    // Создаем объект CommandLineParcer и передаем ему список полученных с коммандной строки аргументов
    // Дополнительно передаем список обязательных ключей
    // Дополнительно определяем являются ли ключи зависимыми от регистра (по умолчанию - нет)
    public CommandLineParcer(String[] args, String[] keys, boolean caseSensitive)
    {
        this.args = args;
        this.keys = keys;
        this.caseSensitive = caseSensitive;
        fixParameters();
    }
    
    // Проверяем наличие указанного ключа в полученных
    public boolean isKeyExist(String keyName)
    {
        boolean result = false;
        int separatorPosition = 0;
        
        for(String key: args)
        {
            if(key.length() > 0)
            {
                // Проверяем наличие разделителя ключ/значение
                if((separatorPosition = key.indexOf(separator)) > 0) 
                {
                    // Удаляем все что не относится к самому ключу
                    key = key.substring(0, separatorPosition).trim();
                }

                if(caseSensitive)
                {
                    // Версия для ключенй ЗАВИСИМЫХ от регистра
                    if(key.equals(keyName.trim()))
                    {
                        result = true;
                        break;
                    }
                }
                else
                {
                    // Версия для ключей независимых от регистра
                    if(key.toUpperCase().equals(keyName.trim().toUpperCase()))
                    {
                        result = true;
                        break;
                    }
                }
            }
        }
        
        return result;
    }
    
    // Вернуть значение указанного ключа
    public String getKeyValue(String keyName)
    {
        String result = null;

        int separatorPosition = 0;
        
        for(String key: args)
        {
            String value = null; // При каждой иттерации необходимо очистить значение
            
            // Проверяем наличие разделителя ключ/значение
            if((separatorPosition = key.indexOf(separator)) > 0) 
            {
                value = key.substring(separatorPosition+1).trim(); // Значение 
                key = key.substring(0, separatorPosition).trim(); // Ключ
            }
                
            if(caseSensitive)
            {
                // Версия для ключенй ЗАВИСИМЫХ от регистра
                if(key.equals(keyName.trim()))
                {
                    result = value;
                    break;
                }
            }
            else
            {
                // Версия для ключей независимых от регистра
                if(key.toUpperCase().equals(keyName.trim().toUpperCase()))
                {
                    result = value;
                    break;
                }
            }
        }
        
        return result;
    }
    
    // Вернуть количество полученных ключей
    public int getKeysCount()
    {
        return keysCount;
    }
    
    // Вернуть кол-во неизвестных ключей
    // N/B: Имеет смысл только если мы заранее определили список известных ключей
    // при помощи параметра 'keys' конструктора класса
    public int getUnknownKeysCount()
    {
        int separatorPosition = 0;
        boolean keyFound = false;
        int result = 0;
        
        if(keys.length > 0)
        {
            for(String key: args)
            {      
                if(key.length() > 0)
                {
                    keyFound = false;

                    // Проверяем наличие разделителя ключ/значение
                    if((separatorPosition = key.indexOf(separator)) > 0) 
                    {
                        // Удаляем все что не относится к самому ключу
                        key = key.substring(0, separatorPosition).trim();
                    }

                    for(String trueKey: keys)
                    {
                        if(caseSensitive)
                        {
                            if(key.equals(trueKey))
                            {
                                keyFound = true;
                                break;
                            }
                        }
                        else
                        {
                            if(key.toLowerCase().equals(trueKey.toLowerCase()))
                            {
                                keyFound = true;
                                break;
                            }
                        }
                    }

                    if(!keyFound)
                    {
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
    
    // Вернуть массив содержащий не верные ключи
    // N/B: Имеет смысл только если мы заранее определили список известных ключей
    // при помощи параметра 'keys' конструктора класса
    public String[] getUnknownKeys()
    {
        int separatorPosition = 0;
        boolean keyFound = false;
        int wrongKeysCount = getUnknownKeysCount();
        String wrongKeys[] = new String[wrongKeysCount];
        int keyNumber = 0;
        
        if(wrongKeysCount > 0)
        {
            for(String key: args)
            {      
                if(key.length() > 0)
                {
                    keyFound = false;
                    
                    // Проверяем наличие разделителя ключ/значение
                    if((separatorPosition = key.indexOf(separator)) > 0) 
                    {
                        // Удаляем все что не относится к самому ключу
                        key = key.substring(0, separatorPosition).trim();
                    }

                    for(String trueKey: keys)
                    {
                        if(caseSensitive)
                        {
                            if(key.equals(trueKey))
                            {
                                keyFound = true;
                                break;
                            }
                        }
                        else
                        {
                            if(key.toLowerCase().equals(trueKey.toLowerCase()))
                            {
                                keyFound = true;
                                break;
                            }
                        }
                    }

                    if(!keyFound)
                    {
                        wrongKeys[keyNumber++] = key;
                    }
                }
            }
        }
        
        return wrongKeys;
    }
    
    /**
     * Убрать лишние кавычки если параметер передается в виде "-param1=2343"
     * или в виде '-param1="2343"'
     */
    private void fixParameters()
    {
        if(keys.length > 0)
        {
            for(String key: args)
            {  
                if(key.length() > 0)
                {
                    if(key.charAt(0) == "'".charAt(0) && key.charAt(key.length()-1) == "'".charAt(0))
                    {
                        key = key.substring(1, key.length()-3);
                        System.out.println(key);
                    }
                    if(key.charAt(0) == "\"".charAt(0) && key.charAt(key.length()-1) == "\"".charAt(0))
                    {
                        key = key.substring(1, key.length()-3);
                    }
                    
                    keysCount++;
                }
            }
        }
    }
    
}
