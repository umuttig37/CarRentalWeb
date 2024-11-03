async function fetchTranslations(languageCode, countryCode, page) {
    try {
        const response = await fetch(`/api/localization/messages?lang=${languageCode}&country=${countryCode}&page=${page}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return await response.json();
    } catch (error) {
        console.error('Failed to fetch translations:', error);
        return null;
    }
}
