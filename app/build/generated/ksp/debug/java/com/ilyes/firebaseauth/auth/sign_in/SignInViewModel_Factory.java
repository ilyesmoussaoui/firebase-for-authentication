package com.ilyes.firebaseauth.auth.sign_in;

import com.ilyes.firebaseauth.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SignInViewModel_Factory implements Factory<SignInViewModel> {
  private final Provider<AuthRepository> repoProvider;

  public SignInViewModel_Factory(Provider<AuthRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public SignInViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static SignInViewModel_Factory create(Provider<AuthRepository> repoProvider) {
    return new SignInViewModel_Factory(repoProvider);
  }

  public static SignInViewModel newInstance(AuthRepository repo) {
    return new SignInViewModel(repo);
  }
}
